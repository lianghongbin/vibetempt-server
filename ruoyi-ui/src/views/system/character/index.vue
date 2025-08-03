<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="角色名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入角色名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建者ID" prop="creatorId">
        <el-input
          v-model="queryParams.creatorId"
          placeholder="请输入创建者ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否激活" prop="isActive">
        <el-input
          v-model="queryParams.isActive"
          placeholder="请输入是否激活"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否公开" prop="isPublic">
        <el-input
          v-model="queryParams.isPublic"
          placeholder="请输入是否公开"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用用户数" prop="totalUsers">
        <el-input
          v-model="queryParams.totalUsers"
          placeholder="请输入使用用户数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总对话数" prop="totalConversations">
        <el-input
          v-model="queryParams.totalConversations"
          placeholder="请输入总对话数"
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
          v-hasPermi="['system:character:add']"
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
          v-hasPermi="['system:character:edit']"
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
          v-hasPermi="['system:character:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:character:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="characterList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="角色ID" align="center" prop="id" />
      <el-table-column label="角色名称" align="center" prop="name" />
      <el-table-column label="角色描述" align="center" prop="description" />
      <el-table-column label="性格设定" align="center" prop="personality" />
      <el-table-column label="头像URL" align="center" prop="avatarUrl" />
      <el-table-column label="角色类型：girlfriend-女友,friend-朋友,mentor-导师,assistant-助手" align="center" prop="characterType" />
      <el-table-column label="创建者ID" align="center" prop="creatorId" />
      <el-table-column label="是否激活" align="center" prop="isActive" />
      <el-table-column label="是否公开" align="center" prop="isPublic" />
      <el-table-column label="使用用户数" align="center" prop="totalUsers" />
      <el-table-column label="总对话数" align="center" prop="totalConversations" />
      <el-table-column label="总消息数" align="center" prop="totalMessages" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:character:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:character:remove']"
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

    <!-- 添加或修改AI角色对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="角色名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入角色名称" />
        </el-form-item>
        <el-form-item label="角色描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="性格设定" prop="personality">
          <el-input v-model="form.personality" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="头像URL" prop="avatarUrl">
          <el-input v-model="form.avatarUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建者ID" prop="creatorId">
          <el-input v-model="form.creatorId" placeholder="请输入创建者ID" />
        </el-form-item>
        <el-form-item label="是否激活" prop="isActive">
          <el-input v-model="form.isActive" placeholder="请输入是否激活" />
        </el-form-item>
        <el-form-item label="是否公开" prop="isPublic">
          <el-input v-model="form.isPublic" placeholder="请输入是否公开" />
        </el-form-item>
        <el-form-item label="使用用户数" prop="totalUsers">
          <el-input v-model="form.totalUsers" placeholder="请输入使用用户数" />
        </el-form-item>
        <el-form-item label="总对话数" prop="totalConversations">
          <el-input v-model="form.totalConversations" placeholder="请输入总对话数" />
        </el-form-item>
        <el-form-item label="总消息数" prop="totalMessages">
          <el-input v-model="form.totalMessages" placeholder="请输入总消息数" />
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
import { listCharacter, getCharacter, delCharacter, addCharacter, updateCharacter } from "@/api/system/character"

export default {
  name: "Character",
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
      // AI角色表格数据
      characterList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        description: null,
        personality: null,
        avatarUrl: null,
        characterType: null,
        creatorId: null,
        isActive: null,
        isPublic: null,
        totalUsers: null,
        totalConversations: null,
        totalMessages: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "角色名称不能为空", trigger: "blur" }
        ],
        creatorId: [
          { required: true, message: "创建者ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询AI角色列表 */
    getList() {
      this.loading = true
      listCharacter(this.queryParams).then(response => {
        this.characterList = response.rows
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
        name: null,
        description: null,
        personality: null,
        avatarUrl: null,
        characterType: null,
        creatorId: null,
        isActive: null,
        isPublic: null,
        totalUsers: null,
        totalConversations: null,
        totalMessages: null,
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
      this.title = "添加AI角色"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getCharacter(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改AI角色"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCharacter(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addCharacter(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除AI角色编号为"' + ids + '"的数据项？').then(function() {
        return delCharacter(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/character/export', {
        ...this.queryParams
      }, `character_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
