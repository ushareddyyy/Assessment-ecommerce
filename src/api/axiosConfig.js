import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:9000', // your Spring Boot backend
});

export default axiosInstance;
