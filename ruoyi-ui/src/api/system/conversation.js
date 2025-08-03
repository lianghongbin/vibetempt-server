import request from '@/utils/request'

// 查询对话会话列表
export function listConversation(query) {
  return request({
    url: '/system/conversation/list',
    method: 'get',
    params: query
  })
}

// 查询对话会话详细
export function getConversation(id) {
  return request({
    url: '/system/conversation/' + id,
    method: 'get'
  })
}

// 新增对话会话
export function addConversation(data) {
  return request({
    url: '/system/conversation',
    method: 'post',
    data: data
  })
}

// 修改对话会话
export function updateConversation(data) {
  return request({
    url: '/system/conversation',
    method: 'put',
    data: data
  })
}

// 删除对话会话
export function delConversation(id) {
  return request({
    url: '/system/conversation/' + id,
    method: 'delete'
  })
}
