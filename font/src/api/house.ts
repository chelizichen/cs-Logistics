import request from "../utils/http";

const getAllHouses = (pagination: pagination) => {
  return request({
    url: "/house",
    params: pagination,
  });
};

const getHouseById = (id:string) => {
  return request.get(`/house/${id}`);
};

const createHouse = (data:house_table) => {
  return request.post("/house", data);
};

const updateHouse = (id:string, data:house_table) => {
  return request.put(`/house/${id}`, data);
};

const deleteHouse = (id:string) => {
  return request.delete(`/house/${id}`);
};

export  {
  getAllHouses,
  getHouseById,
  createHouse,
  updateHouse,
  deleteHouse,
};
