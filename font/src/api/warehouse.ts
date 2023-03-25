import request from "../utils/http";

const getAllWarehouses = () => {
    return request.get('/warehouses');
  };
  
  const getWarehouseById = (id) => {
    return request.get(`/warehouses/${id}`);
  };
  
  const createWarehouse = (data) => {
    return request.post('/warehouses', data);
  };
  
  const updateWarehouse = (id, data) => {
    return request.put(`/warehouses/${id}`, data);
  };
  
  const deleteWarehouse = (id) => {
    return request.delete(`/warehouses/${id}`);
  };
  
  export default {
    getAllWarehouses,
    getWarehouseById,
    createWarehouse,
    updateWarehouse,
    deleteWarehouse,
  };
  