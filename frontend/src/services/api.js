import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// קבלת כל המשימות
export const getTasks = () => api.get('/tasks');

// יצירת משימה חדשה
export const createTask = (task) => api.post('/tasks', task);

// עדכון סטטוס משימה (למשל סימון כהושלם)
export const updateTask = (id, data = {}) => api.put(`/tasks/${id}`, data);

// מחיקת משימה
export const deleteTask = (id) => api.delete(`/tasks/${id}`);
