import request from "../utils/http";


const getAllOrders = () => {
  return request.get('/orders');
};

const getOrderById = (id) => {
  return request.get(`/orders/${id}`);
};

const createOrder = (data) => {
  return request.post('/orders', data);
};

const updateOrder = (id, data) => {
  return request.put(`/orders/${id}`, data);
};

const deleteOrder = (id) => {
  return request.delete(`/orders/${id}`);
};

export default {
  getAllOrders,
  getOrderById,
  createOrder,
  updateOrder,
  deleteOrder,
};