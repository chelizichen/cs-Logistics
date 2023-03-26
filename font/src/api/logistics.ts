import request from "../utils/http";

const getAllLogistics = (pagination:pagination) => {
    return request({
      url:'/logistics',
      params:pagination
    });
  };
  
  const getLogisticsById = (id:string) => {
    return request.get(`/logistics/${id}`);
  };
  
  const createLogistics = (data:logistics_table) => {
    return request.post('/logistics', data);
  };
  
  const updateLogistics = (id:string, data:logistics_table) => {
    return request.put(`/logistics/${id}`, data);
  };
  
  const deleteLogistics = (id:string) => {
    return request.delete(`/logistics/${id}`);
  };
  
  export default {
    getAllLogistics,
    getLogisticsById,
    createLogistics,
    updateLogistics,
    deleteLogistics,
  };
  