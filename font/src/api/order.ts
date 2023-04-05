import request from "../utils/http";


const getAllOrders = (pagination:pagination) => {
  return request({
   url: '/orders',
   params:pagination
  });
};

const getOrderById = (id:string) => {
  return request.get(`/orders/${id}`);
};

const createOrder = (data:Partial<orders_table>) => {
  return request.post('/orders', data);
};

const updateOrder = (id:string, data:Partial<orders_table>) => {
  return request.put(`/orders/${id}`, data);
};

const deleteOrder = (id:string) => {
  return request.delete(`/orders/${id}`);
};

const getOrderByUserId = (id: string) => {
  return request.get(`/orders/user/${id}`);
};
const getBackList = (params: pagination) => {
  return request({ url: `/orders/back`, params });
};



export {
  getAllOrders,
  getOrderById,
  createOrder,
  updateOrder,
  deleteOrder,
  getOrderByUserId,
  getBackList,
};