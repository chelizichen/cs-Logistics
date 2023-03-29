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

export  {
  getAllOrders,
  getOrderById,
  createOrder,
  updateOrder,
  deleteOrder,
};