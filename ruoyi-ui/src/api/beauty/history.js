import request from '@/utils/request'

// 查询订单历史列表
export function listHistory(query) {
  return request({
    url: '/beauty/history/list',
    method: 'get',
    params: query
  })
}

// 查询订单历史详细
export function getHistory(id) {
  return request({
    url: '/beauty/history/' + id,
    method: 'get'
  })
}

// 新增订单历史
export function addHistory(data) {
  return request({
    url: '/beauty/history',
    method: 'post',
    data: data
  })
}

// 修改订单历史
export function updateHistory(data) {
  return request({
    url: '/beauty/history',
    method: 'put',
    data: data
  })
}

// 删除订单历史
export function delHistory(id) {
  return request({
    url: '/beauty/history/' + id,
    method: 'delete'
  })
}
