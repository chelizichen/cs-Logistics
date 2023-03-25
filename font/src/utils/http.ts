import axios from 'axios'

const request = axios.create({
    baseURL:"localhost:8080/",
})

request.interceptors.response.use(function(response){
    return response.data
})


export default request
