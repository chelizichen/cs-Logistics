import request from "../utils/http";

export function getList(params:pagination) {
  return request({
    url: "/complaints/list",
    params
  });
}

export function one(params: { id: string }) {
    return request({
      url: "/complaints/one",
      params,
    });
}

export function del(params: { id: string }) {
  return request({
    url: "/complaints/del",
    params,
  });
}


export function update(data:any) {
  return request({
    url: "/complaints/update",
    method:"post",
    data,
  });
}