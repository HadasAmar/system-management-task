import React, { useState } from 'react';
import { createTask } from '../services/api';

function TaskForm({ onAdd }) {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [error, setError] = useState(null);

  const handleSubmit = e => {
    e.preventDefault();
    const errors = validate();
    if (Object.keys(errors).length > 0) {
      setError(errors);
      return;
    }
    setError({})
    createTask({ taskName: name, taskDescription: description })
    .then(res => {
      console.log(res.data.message)
      setName('');
      setDescription('');
      onAdd();
    })
    .catch(err => {
      console.error("Error creating task:", err);
    });
  };

  const validate = () => {
    const errors = {};
    if (!name.trim()) {
      errors.name = "Task name is required";
    } else if (name.length > 50) {
      errors.name = "Task name must not exceed 50 characters";
    }
    if (description.length > 200) {
      errors.description = "Description must not exceed 200 characters";
    }
    return errors;
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4">
      <div className="mb-3">
        <input
          type="text"
          value={name}
          onChange={e => setName(e.target.value)}
          placeholder="Task name"
          className="form-control"
          required
        />
        {error?.name && <div className="text-danger mt-1">{error?.name}</div>}
      </div>
      <div className="mb-3">
        <input
          type="text"
          value={description}
          onChange={e => setDescription(e.target.value)}
          placeholder="Description"
          className="form-control"
        />
        {error?.description && <div className="text-danger mt-1">{error?.description}</div>}
      </div>
      <button className="btn w-100" style={{ backgroundColor: ' #057977' }}>Add Task</button>
    </form>
  );
}

export default TaskForm;