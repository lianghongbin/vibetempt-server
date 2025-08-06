import request from '@/utils/request'

// 查询角色记忆列表
export function listMemory(query) {
  return request({
    url: '/vitetempt/memory/list',
    method: 'get',
    params: query
  })
}

// 查询角色记忆详细
export function getMemory(id) {
  return request({
    url: '/vitetempt/memory/' + id,
    method: 'get'
  })
}

// 新增角色记忆
export function addMemory(data) {
  return request({
    url: '/vitetempt/memory',
    method: 'post',
    data: data
  })
}

// 修改角色记忆
export function updateMemory(data) {
  return request({
    url: '/vitetempt/memory',
    method: 'put',
    data: data
  })
}

// 删除角色记忆
export function delMemory(id) {
  return request({
    url: '/vitetempt/memory/' + id,
    method: 'delete'
  })
}
