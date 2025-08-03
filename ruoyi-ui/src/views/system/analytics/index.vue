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
      <el-form-item label="日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="消息数量" prop="messageCount">
        <el-input
          v-model="queryParams.messageCount"
          placeholder="请输入消息数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="对话数量" prop="conversationCount">
        <el-input
          v-model="queryParams.conversationCount"
          placeholder="请输入对话数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总时长(分钟)" prop="totalDuration">
        <el-input
          v-model="queryParams.totalDuration"
          placeholder="请输入总时长(分钟)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Token使用量" prop="tokensUsed">
        <el-input
          v-model="queryParams.tokensUsed"
          placeholder="请输入Token使用量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均情感值" prop="averageSentiment">
        <el-input
          v-model="queryParams.averageSentiment"
          placeholder="请输入平均情感值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主要情感" prop="dominantEmotion">
        <el-input
          v-model="queryParams.dominantEmotion"
          placeholder="请输入主要情感"
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
          v-hasPermi="['system:analytics:add']"
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
          v-hasPermi="['system:analytics:edit']"
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
          v-hasPermi="['system:analytics:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:analytics:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="analyticsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="统计ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="角色ID" align="center" prop="characterId" />
      <el-table-column label="日期" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="消息数量" align="center" prop="messageCount" />
      <el-table-column label="对话数量" align="center" prop="conversationCount" />
      <el-table-column label="总时长(分钟)" align="center" prop="totalDuration" />
      <el-table-column label="Token使用量" align="center" prop="tokensUsed" />
      <el-table-column label="平均情感值" align="center" prop="averageSentiment" />
      <el-table-column label="主要情感" align="center" prop="dominantEmotion" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:analytics:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:analytics:remove']"
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

    <!-- 添加或修改聊天统计对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="角色ID" prop="characterId">
          <el-input v-model="form.characterId" placeholder="请输入角色ID" />
        </el-form-item>
        <el-form-item label="日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="消息数量" prop="messageCount">
          <el-input v-model="form.messageCount" placeholder="请输入消息数量" />
        </el-form-item>
        <el-form-item label="对话数量" prop="conversationCount">
          <el-input v-model="form.conversationCount" placeholder="请输入对话数量" />
        </el-form-item>
        <el-form-item label="总时长(分钟)" prop="totalDuration">
          <el-input v-model="form.totalDuration" placeholder="请输入总时长(分钟)" />
        </el-form-item>
        <el-form-item label="Token使用量" prop="tokensUsed">
          <el-input v-model="form.tokensUsed" placeholder="请输入Token使用量" />
        </el-form-item>
        <el-form-item label="平均情感值" prop="averageSentiment">
          <el-input v-model="form.averageSentiment" placeholder="请输入平均情感值" />
        </el-form-item>
        <el-form-item label="主要情感" prop="dominantEmotion">
          <el-input v-model="form.dominantEmotion" placeholder="请输入主要情感" />
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
import { listAnalytics, getAnalytics, delAnalytics, addAnalytics, updateAnalytics } from "@/api/system/analytics"

export default {
  name: "Analytics",
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
      // 聊天统计表格数据
      analyticsList: [],
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
        date: null,
        messageCount: null,
        conversationCount: null,
        totalDuration: null,
        tokensUsed: null,
        averageSentiment: null,
        dominantEmotion: null,
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
        date: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询聊天统计列表 */
    getList() {
      this.loading = true
      listAnalytics(this.queryParams).then(response => {
        this.analyticsList = response.rows
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
        date: null,
        messageCount: null,
        conversationCount: null,
        totalDuration: null,
        tokensUsed: null,
        averageSentiment: null,
        dominantEmotion: null,
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
      this.title = "添加聊天统计"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getAnalytics(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改聊天统计"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAnalytics(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addAnalytics(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除聊天统计编号为"' + ids + '"的数据项？').then(function() {
        return delAnalytics(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/analytics/export', {
        ...this.queryParams
      }, `analytics_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
