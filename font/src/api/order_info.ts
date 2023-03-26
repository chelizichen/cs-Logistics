import request from "../utils/http";

const getAllOrderInfo = (pagination: pagination) => {
  return request({
    url: "/order_info",
    params: pagination,
  });
};

const getOrderInfoById = (id: string) => {
  return request.get(`/order_info/${id}`);
};

const createOrderInfo = (data: order_info_table) => {
  return request.post("/order_info", data);
};

const updateOrderInfo = (id: string, data: order_info_table) => {
  return request.put(`/order_info/${id}`, data);
};

const deleteOrderInfo = (id: string) => {
  return request.delete(`/order_info/${id}`);
};

export default {
  getAllOrderInfo,
  getOrderInfoById,
  createOrderInfo,
  updateOrderInfo,
  deleteOrderInfo,
};
