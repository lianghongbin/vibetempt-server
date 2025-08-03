#!/bin/bash

# 一键启动所有服务脚本
# 用于启动数据库、后端、前端等所有服务

set -e

# 颜色定义
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 脚本目录
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

# 默认配置
INIT_DB=false
START_BACKEND=true
START_FRONTEND=true
BACKEND_PROFILE="dev"
FRONTEND_PORT="3000"

echo -e "${BLUE}🚀 一键启动所有服务...${NC}"
echo "项目根目录: $PROJECT_ROOT"
echo ""

# 显示帮助信息
show_help() {
    echo "用法: $0 [选项]"
    echo ""
    echo "选项:"
    echo "  -d, --init-db            初始化数据库"
    echo "  -b, --backend-only       仅启动后端服务"
    echo "  -f, --frontend-only      仅启动前端服务"
    echo "  -p, --profile PROFILE    后端环境 (dev/prod, 默认: dev)"
    echo "  -P, --port PORT          前端端口 (默认: 3000)"
    echo "  -h, --help               显示此帮助信息"
    echo ""
    echo "示例:"
    echo "  $0                    # 启动所有服务"
    echo "  $0 -d                # 初始化数据库并启动所有服务"
    echo "  $0 -b -p prod        # 仅启动生产环境后端"
    echo "  $0 -f -P 3001        # 仅启动前端服务(端口3001)"
}

# 解析命令行参数
parse_args() {
    while [[ $# -gt 0 ]]; do
        case $1 in
            -d|--init-db)
                INIT_DB=true
                shift
                ;;
            -b|--backend-only)
                START_FRONTEND=false
                shift
                ;;
            -f|--frontend-only)
                START_BACKEND=false
                shift
                ;;
            -p|--profile)
                BACKEND_PROFILE="$2"
                shift 2
                ;;
            -P|--port)
                FRONTEND_PORT="$2"
                shift 2
                ;;
            -h|--help)
                show_help
                exit 0
                ;;
            *)
                echo -e "${RED}❌ 未知参数: $1${NC}"
                show_help
                exit 1
                ;;
        esac
    done
}

# 检查环境
check_environment() {
    echo -e "${BLUE}🔍 检查运行环境...${NC}"
    
    # 检查必要的命令
    local commands=("java" "mvn" "node" "npm" "mysql")
    local missing_commands=()
    
    for cmd in "${commands[@]}"; do
        if ! command -v "$cmd" &> /dev/null; then
            missing_commands+=("$cmd")
        fi
    done
    
    if [[ ${#missing_commands[@]} -gt 0 ]]; then
        echo -e "${RED}❌ 缺少必要的命令: ${missing_commands[*]}${NC}"
        return 1
    fi
    
    echo -e "${GREEN}✅ 环境检查通过${NC}"
}

# 初始化数据库
init_database() {
    if [[ "$INIT_DB" == "true" ]]; then
        echo -e "${BLUE}🗄️  初始化数据库...${NC}"
        
        if [[ -f "$SCRIPT_DIR/database/init-database.sh" ]]; then
            bash "$SCRIPT_DIR/database/init-database.sh"
        else
            echo -e "${YELLOW}⚠️  数据库初始化脚本不存在${NC}"
        fi
    fi
}

# 启动后端服务
start_backend_service() {
    if [[ "$START_BACKEND" == "true" ]]; then
        echo -e "${BLUE}🔧 启动后端服务...${NC}"
        
        if [[ -f "$SCRIPT_DIR/ry/start-backend.sh" ]]; then
            bash "$SCRIPT_DIR/ry/start-backend.sh" -p "$BACKEND_PROFILE"
        else
            echo -e "${YELLOW}⚠️  后端启动脚本不存在${NC}"
        fi
    fi
}

# 启动前端服务
start_frontend_service() {
    if [[ "$START_FRONTEND" == "true" ]]; then
        echo -e "${BLUE}🔧 启动前端服务...${NC}"
        
        if [[ -f "$SCRIPT_DIR/ry/start-frontend.sh" ]]; then
            bash "$SCRIPT_DIR/ry/start-frontend.sh" -P "$FRONTEND_PORT"
        else
            echo -e "${YELLOW}⚠️  前端启动脚本不存在${NC}"
        fi
    fi
}

# 等待服务启动
wait_for_services() {
    echo -e "${BLUE}⏳ 等待服务启动...${NC}"
    
    local backend_url="http://localhost:8080"
    local frontend_url="http://localhost:$FRONTEND_PORT"
    
    # 等待后端服务
    if [[ "$START_BACKEND" == "true" ]]; then
        echo -e "${BLUE}等待后端服务...${NC}"
        local attempts=0
        local max_attempts=60
        
        while [[ $attempts -lt $max_attempts ]]; do
            if curl -s "$backend_url" >/dev/null 2>&1; then
                echo -e "${GREEN}✅ 后端服务已就绪${NC}"
                break
            fi
            
            sleep 2
            attempts=$((attempts + 1))
            echo -n "."
        done
        
        if [[ $attempts -eq $max_attempts ]]; then
            echo -e "${YELLOW}⚠️  后端服务启动超时${NC}"
        fi
    fi
    
    # 等待前端服务
    if [[ "$START_FRONTEND" == "true" ]]; then
        echo -e "${BLUE}等待前端服务...${NC}"
        local attempts=0
        local max_attempts=60
        
        while [[ $attempts -lt $max_attempts ]]; do
            if curl -s "$frontend_url" >/dev/null 2>&1; then
                echo -e "${GREEN}✅ 前端服务已就绪${NC}"
                break
            fi
            
            sleep 2
            attempts=$((attempts + 1))
            echo -n "."
        done
        
        if [[ $attempts -eq $max_attempts ]]; then
            echo -e "${YELLOW}⚠️  前端服务启动超时${NC}"
        fi
    fi
}

# 显示服务信息
show_service_info() {
    echo ""
    echo -e "${BLUE}📊 服务信息:${NC}"
    
    if [[ "$START_BACKEND" == "true" ]]; then
        echo -e "  后端服务: ${GREEN}http://localhost:8080${NC}"
        echo -e "  环境配置: ${GREEN}$BACKEND_PROFILE${NC}"
        echo -e "  Swagger文档: ${GREEN}http://localhost:8080/swagger-ui.html${NC}"
    fi
    
    if [[ "$START_FRONTEND" == "true" ]]; then
        echo -e "  前端服务: ${GREEN}http://localhost:$FRONTEND_PORT${NC}"
    fi
    
    echo ""
    echo -e "${BLUE}🔧 管理命令:${NC}"
    echo -e "  停止所有服务: ${GREEN}bash scripts/utils/stop-services.sh${NC}"
    echo -e "  查看服务状态: ${GREEN}bash scripts/utils/stop-services.sh -s${NC}"
    echo -e "  清理临时文件: ${GREEN}bash scripts/utils/stop-services.sh -c${NC}"
}

# 主函数
main() {
    echo "=========================================="
    echo "        一键启动所有服务脚本"
    echo "=========================================="
    echo ""
    
    # 解析参数
    parse_args "$@"
    
    # 显示启动配置
    echo -e "${BLUE}📋 启动配置:${NC}"
    echo "  初始化数据库: $INIT_DB"
    echo "  启动后端服务: $START_BACKEND"
    echo "  启动前端服务: $START_FRONTEND"
    if [[ "$START_BACKEND" == "true" ]]; then
        echo "  后端环境: $BACKEND_PROFILE"
    fi
    if [[ "$START_FRONTEND" == "true" ]]; then
        echo "  前端端口: $FRONTEND_PORT"
    fi
    echo ""
    
    # 执行启动步骤
    check_environment && \
    init_database && \
    start_backend_service && \
    start_frontend_service && \
    wait_for_services
    
    if [[ $? -eq 0 ]]; then
        show_service_info
        echo -e "${GREEN}🎉 所有服务启动完成！${NC}"
    else
        echo -e "${RED}❌ 服务启动过程中出现错误！${NC}"
        exit 1
    fi
}

# 运行主函数
main "$@" 