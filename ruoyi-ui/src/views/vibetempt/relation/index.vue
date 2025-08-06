<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="角色ID" prop="characterId">
        <el-input
          v-model="queryParams.characterId"
          placeholder="请输入角色ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关系等级(1-10)" prop="relationshipLevel">
        <el-input
          v-model="queryParams.relationshipLevel"
          placeholder="请输入关系等级(1-10)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="情感状态" prop="emotionalState">
        <el-input
          v-model="queryParams.emotionalState"
          placeholder="请输入情感状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="信任度(1-10)" prop="trustLevel">
        <el-input
          v-model="queryParams.trustLevel"
          placeholder="请输入信任度(1-10)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总互动次数" prop="totalInteractions">
        <el-input
          v-model="queryParams.totalInteractions"
          placeholder="请输入总互动次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总消息数" prop="totalMessages">
        <el-input
          v-model="queryParams.totalMessages"
          placeholder="请输入总消息数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="首次互动时间" prop="firstInteractionTime">
        <el-date-picker clearable
          v-model="queryParams.firstInteractionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择首次互动时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最后互动时间" prop="lastInteractionTime">
        <el-date-picker clearable
          v-model="queryParams.lastInteractionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后互动时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:relation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:relation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:relation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:relation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="relationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="关系ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="角色ID" align="center" prop="characterId" />
      <el-table-column label="关系等级(1-10)" align="center" prop="relationshipLevel" />
      <el-table-column label="情感状态" align="center" prop="emotionalState" />
      <el-table-column label="信任度(1-10)" align="center" prop="trustLevel" />
      <el-table-column label="总互动次数" align="center" prop="totalInteractions" />
      <el-table-column label="总消息数" align="center" prop="totalMessages" />
      <el-table-column label="首次互动时间" align="center" prop="firstInteractionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.firstInteractionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后互动时间" align="center" prop="lastInteractionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastInteractionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:relation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:relation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户角色关系对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="角色ID" prop="characterId">
          <el-input v-model="form.characterId" placeholder="请输入角色ID" />
        </el-form-item>
        <el-form-item label="关系等级(1-10)" prop="relationshipLevel">
          <el-input v-model="form.relationshipLevel" placeholder="请输入关系等级(1-10)" />
        </el-form-item>
        <el-form-item label="情感状态" prop="emotionalState">
          <el-input v-model="form.emotionalState" placeholder="请输入情感状态" />
        </el-form-item>
        <el-form-item label="信任度(1-10)" prop="trustLevel">
          <el-input v-model="form.trustLevel" placeholder="请输入信任度(1-10)" />
        </el-form-item>
        <el-form-item label="总互动次数" prop="totalInteractions">
          <el-input v-model="form.totalInteractions" placeholder="请输入总互动次数" />
        </el-form-item>
        <el-form-item label="总消息数" prop="totalMessages">
          <el-input v-model="form.totalMessages" placeholder="请输入总消息数" />
        </el-form-item>
        <el-form-item label="首次互动时间" prop="firstInteractionTime">
          <el-date-picker clearable
            v-model="form.firstInteractionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择首次互动时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后互动时间" prop="lastInteractionTime">
          <el-date-picker clearable
            v-model="form.lastInteractionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后互动时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRelation, getRelation, delRelation, addRelation, updateRelation } from "@/api/vibetempt/relation"

export default {
  name: "Relation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户角色关系表格数据
      relationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        characterId: null,
        relationshipLevel: null,
        emotionalState: null,
        trustLevel: null,
        totalInteractions: null,
        totalMessages: null,
        firstInteractionTime: null,
        lastInteractionTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        characterId: [
          { required: true, message: "角色ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询用户角色关系列表 */
    getList() {
      this.loading = true
      listRelation(this.queryParams).then(response => {
        this.relationList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        characterId: null,
        relationshipLevel: null,
        emotionalState: null,
        trustLevel: null,
        totalInteractions: null,
        totalMessages: null,
        firstInteractionTime: null,
        lastInteractionTime: null,
        createTime: null,
        updateTime: null,
        createBy: null,
        updateBy: null,
        delFlag: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加用户角色关系"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getRelation(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改用户角色关系"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRelation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addRelation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除用户角色关系编号为"' + ids + '"的数据项？').then(function() {
        return delRelation(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/relation/export', {
        ...this.queryParams
      }, `relation_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
