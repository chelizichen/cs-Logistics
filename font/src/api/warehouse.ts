import request from "../utils/http";

const getAllWarehouses = (pagination: pagination) => {
  return request({
    url: "/warehouses",
    params: pagination,
  });
};

const getWarehouseById = (id:string) => {
  return request.get(`/warehouses/${id}`);
};

const createWarehouse = (data:warehouse_table) => {
  return request.post("/warehouses", data);
};

const updateWarehouse = (id:string, data:warehouse_table) => {
  return request.put(`/warehouses/${id}`, data);
};

const deleteWarehouse = (id:string) => {
  return request.delete(`/warehouses/${id}`);
};

export {
  getAllWarehouses,
  getWarehouseById,
  createWarehouse,
  updateWarehouse,
  deleteWarehouse,
};
