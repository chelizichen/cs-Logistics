import request from "../utils/http";

const getAllUsers = () => {
  return request.get('/users');
};

const getUserById = (id) => {
  return request.get(`/users/${id}`);
};

const createUser = (data) => {
  return request.post('/users', data);
};

const updateUser = (id, data) => {
  return request.put(`/users/${id}`, data);
};

const deleteUser = (id) => {
  return request.delete(`/users/${id}`);
};

export {
  getAllUsers,
  getUserById,
  createUser,
  updateUser,
  deleteUser,
};