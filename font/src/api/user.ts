import request from "../utils/http";

const getAllUsers = (pagination:pagination) => {
  return request({
    url:'/users',
    params:pagination
  });
};

const getUserById = (id:string) => {
  return request.get(`/users/${id}`);
};

const createUser = (data:string) => {
  return request.post('/users', data);
};

const updateUser = (id:string, data:user_table) => {
  return request.put(`/users/${id}`, data);
};

const deleteUser = (id:string) => {
  return request.delete(`/users/${id}`);
};

export {
  getAllUsers,
  getUserById,
  createUser,
  updateUser,
  deleteUser,
};