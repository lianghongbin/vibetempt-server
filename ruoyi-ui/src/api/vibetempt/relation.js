import request from '@/utils/request'

// 查询用户角色关系列表
export function listRelation(query) {
  return request({
    url: '/vibetempt/relation/list',
    method: 'get',
    params: query
  })
}

// 查询用户角色关系详细
export function getRelation(id) {
  return request({
    url: '/vibetempt/relation/' + id,
    method: 'get'
  })
}

// 新增用户角色关系
export function addRelation(data) {
  return request({
    url: '/vibetempt/relation',
    method: 'post',
    data: data
  })
}

// 修改用户角色关系
export function updateRelation(data) {
  return request({
    url: '/vibetempt/relation',
    method: 'put',
    data: data
  })
}

// 删除用户角色关系
export function delRelation(id) {
  return request({
    url: '/vibetempt/relation/' + id,
    method: 'delete'
  })
}
