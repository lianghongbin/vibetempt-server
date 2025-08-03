import request from '@/utils/request'

// 查询AI角色列表
export function listCharacter(query) {
  return request({
    url: '/system/character/list',
    method: 'get',
    params: query
  })
}

// 查询AI角色详细
export function getCharacter(id) {
  return request({
    url: '/system/character/' + id,
    method: 'get'
  })
}

// 新增AI角色
export function addCharacter(data) {
  return request({
    url: '/system/character',
    method: 'post',
    data: data
  })
}

// 修改AI角色
export function updateCharacter(data) {
  return request({
    url: '/system/character',
    method: 'put',
    data: data
  })
}

// 删除AI角色
export function delCharacter(id) {
  return request({
    url: '/system/character/' + id,
    method: 'delete'
  })
}
