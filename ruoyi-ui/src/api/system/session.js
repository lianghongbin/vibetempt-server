import request from '@/utils/request'

// 查询聊天会话状态列表
export function listSession(query) {
  return request({
    url: '/system/session/list',
    method: 'get',
    params: query
  })
}

// 查询聊天会话状态详细
export function getSession(id) {
  return request({
    url: '/system/session/' + id,
    method: 'get'
  })
}

// 新增聊天会话状态
export function addSession(data) {
  return request({
    url: '/system/session',
    method: 'post',
    data: data
  })
}

// 修改聊天会话状态
export function updateSession(data) {
  return request({
    url: '/system/session',
    method: 'put',
    data: data
  })
}

// 删除聊天会话状态
export function delSession(id) {
  return request({
    url: '/system/session/' + id,
    method: 'delete'
  })
}
