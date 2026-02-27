const API_URL = "http://localhost:8080/api/tasks";

window.onload = () => fetchTasks();

// 1. READ ALL
async function fetchTasks() {
    const response = await fetch(API_URL);
    const tasks = await response.json();
    displayTasks(tasks);
}

// 2. SEARCH BY ID
async function searchTaskById() {
    const id = document.getElementById('searchId').value;
    if(!id) return alert("Please enter an ID");

    try {
        const response = await fetch(`${API_URL}/${id}`);
        if(!response.ok) throw new Error("Not found");
        const task = await response.json();
        displayTasks([task]); // List mein sirf ek task dikhao
    } catch (err) {
        alert("Task not found!");
    }
}

// Helper to render cards
function displayTasks(tasks) {
    const container = document.getElementById('tasksContainer');
    container.innerHTML = "";
    tasks.forEach(task => {
        const div = document.createElement('div');
        div.className = 'task-card';
        div.innerHTML = `
            <small>ID: ${task.id}</small>
            <h3>${task.title}</h3>
            <p>${task.description}</p>
            <div class="card-actions">
                <button class="btn-edit" onclick="prepareUpdate(${task.id}, '${task.title}', '${task.description}')">Edit</button>
                <button class="btn-del" onclick="deleteTask(${task.id})">Delete</button>
            </div>
        `;
        container.appendChild(div);
    });
}

// 3. INSERT
async function addTask() {
    const title = document.getElementById('taskTitle').value;
    const description = document.getElementById('taskDesc').value;

    await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description, completed: false })
    });
    resetForm();
    fetchTasks();
}

// 4. PREPARE UPDATE (Fill form)
function prepareUpdate(id, title, desc) {
    document.getElementById('currentTaskId').value = id;
    document.getElementById('taskTitle').value = title;
    document.getElementById('taskDesc').value = desc;
    
    document.getElementById('form-title').innerText = "Update Task " + id;
    document.getElementById('addBtn').style.display = "none";
    document.getElementById('updateBtn').style.display = "inline-block";
    document.getElementById('cancelBtn').style.display = "inline-block";
}

// 5. SAVE UPDATE (PUT)
async function saveUpdate() {
    const id = document.getElementById('currentTaskId').value;
    const title = document.getElementById('taskTitle').value;
    const description = document.getElementById('taskDesc').value;

    await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description, completed: false })
    });
    resetForm();
    fetchTasks();
}

// 6. DELETE
async function deleteTask(id) {
    if(confirm("Are you sure?")) {
        await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        fetchTasks();
    }
}

function resetForm() {
    document.getElementById('currentTaskId').value = "";
    document.getElementById('taskTitle').value = "";
    document.getElementById('taskDesc').value = "";
    document.getElementById('form-title').innerText = "Add New Task";
    document.getElementById('addBtn').style.display = "inline-block";
    document.getElementById('updateBtn').style.display = "none";
    document.getElementById('cancelBtn').style.display = "none";
}