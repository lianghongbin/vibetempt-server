import request from '@/utils/request'

// 查询聊天统计列表
export function listAnalytics(query) {
  return request({
    url: '/vibetempt/analytics/list',
    method: 'get',
    params: query
  })
}

// 查询聊天统计详细
export function getAnalytics(id) {
  return request({
    url: '/vibetempt/analytics/' + id,
    method: 'get'
  })
}

// 新增聊天统计
export function addAnalytics(data) {
  return request({
    url: '/vibetempt/analytics',
    method: 'post',
    data: data
  })
}

// 修改聊天统计
export function updateAnalytics(data) {
  return request({
    url: '/vibetempt/analytics',
    method: 'put',
    data: data
  })
}

// 删除聊天统计
export function delAnalytics(id) {
  return request({
    url: '/vibetempt/analytics/' + id,
    method: 'delete'
  })
}
