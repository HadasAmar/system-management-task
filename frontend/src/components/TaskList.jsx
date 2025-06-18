import React from 'react';
import { deleteTask, updateTask } from '../services/api';

function TaskList({ tasks, onUpdate }) {
  const handleComplete = id => {
    updateTask(id)
      .then(res => {
        onUpdate();
        console.log(res.data.message)})
      .catch(err => console.error("Error updating task:", err));
  };

  const handleDelete = id => {
    deleteTask(id)
      .then(res => {
        onUpdate();
        console.log(res.data.message)})
      .catch(err => console.error("Error deleting task:", err));
  };

  return (
    <ul className="list-group">
      {tasks.map(task => (
        <li
          key={task.id}
          className={`list-group-item d-flex justify-content-between align-items-center ${task.completed ? 'list-group-item-success' : 'list-group-item-danger'}`}
        >
          <div>
            <strong>{task.name}</strong>
            <br />
            <small>{task.description}</small>
          </div>
          <div>
            <button
              onClick={() => handleComplete(task.id)}
              className="btn btn-sm btn-outline-success me-2"
              disabled={task.completed}
            >
              ✓
            </button>
            <button
              onClick={() => handleDelete(task.id)}
              className="btn btn-sm btn-outline-danger"
            >
              ✕
            </button>
          </div>
        </li>
      ))}
    </ul>
  );
}

export default TaskList;