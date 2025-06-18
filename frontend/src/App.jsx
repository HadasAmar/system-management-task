import React, { useEffect, useState } from 'react';
import TaskForm from './components/TaskForm';
import TaskList from './components/TaskList';
import 'bootstrap/dist/css/bootstrap.min.css';
import { getTasks } from './services/api';

function App() {
  const [tasks, setTasks] = useState([]);

  const fetchTasks = () => {
    getTasks()
      .then(res => {
        setTasks(res.data.data);
        console.log(res.data.message)})
      .catch(err => {
        console.error("Error fetching tasks:", err);
        setTasks([]);
      });
      
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  return (
    <div className="d-flex justify-content-center align-items-center min-vh-100" style={{ backgroundColor: '#057977' }}>
      <div className="card shadow p-4"
        style={{
          width: '100%',
          maxWidth: '600px',
          backgroundColor: '#f5f5f5',
          maxHeight: '500px',
          overflowY: 'auto'
        }}>
        <h1 className="text-center mb-4 text-dark">📝 Task Manager</h1>
        <TaskForm onAdd={fetchTasks} />
        <TaskList tasks={tasks} onUpdate={fetchTasks} />
      </div>
    </div>
  );
}

export default App;