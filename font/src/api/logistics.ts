import request from "../utils/http";

const getAllLogistics = () => {
    return request.get('/logistics');
  };
  
  const getLogisticsById = (id) => {
    return request.get(`/logistics/${id}`);
  };
  
  const createLogistics = (data) => {
    return request.post('/logistics', data);
  };
  
  const updateLogistics = (id, data) => {
    return request.put(`/logistics/${id}`, data);
  };
  
  const deleteLogistics = (id) => {
    return request.delete(`/logistics/${id}`);
  };
  
  export default {
    getAllLogistics,
    getLogisticsById,
    createLogistics,
    updateLogistics,
    deleteLogistics,
  };
  