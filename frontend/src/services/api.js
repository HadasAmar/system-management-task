import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// get all tasks
export const getTasks = () => api.get('/tasks');

// create a new task
export const createTask = (task) => api.post('/tasks', task);

// update a task
export const updateTask = (id, data = {}) => api.put(`/tasks/${id}`, data);

// delete a task
export const deleteTask = (id) => api.delete(`/tasks/${id}`);
