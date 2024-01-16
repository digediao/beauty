import request from '@/utils/request'

// 查询商品店家列表
export function listStore(query) {
  return request({
    url: '/beauty/store/list',
    method: 'get',
    params: query
  })
}

// 查询商品店家详细
export function getStore(id) {
  return request({
    url: '/beauty/store/' + id,
    method: 'get'
  })
}

// 新增商品店家
export function addStore(data) {
  return request({
    url: '/beauty/store',
    method: 'post',
    data: data
  })
}

// 修改商品店家
export function updateStore(data) {
  return request({
    url: '/beauty/store',
    method: 'put',
    data: data
  })
}

// 删除商品店家
export function delStore(id) {
  return request({
    url: '/beauty/store/' + id,
    method: 'delete'
  })
}
