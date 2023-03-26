import axios from 'axios'

const request = axios.create({
    baseURL:"/server/",
    headers: { "Content-Type": "application/json;charset=utf-8" },
})

request.interceptors.response.use(function(response){
    return response.data
})


export default request
