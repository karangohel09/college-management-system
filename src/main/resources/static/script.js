const FACULTY_API = "https://college-management-system-rjdu.onrender.com/api/faculties";
const STUDENT_API = "https://college-management-system-rjdu.onrender.com/api/students";

// =======================
// FACULTY SECTION
// =======================
const facultyForm = document.getElementById("faculty-form");
const facultyTable = document.getElementById("faculty-table-body");

facultyForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("faculty-id").value;
  const name = document.getElementById("faculty-name").value;
  const subject = document.getElementById("faculty-subject").value;
  const age = parseInt(document.getElementById("faculty-age").value);
  const salary = parseInt(document.getElementById("faculty-salary").value);

  const data = { name, subject, age, salary };

  await fetch(`${FACULTY_API}${id ? '/' + id : ''}`, {
    method: id ? "PUT" : "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });

  facultyForm.reset();
  document.getElementById("faculty-id").value = "";
  loadFaculties();
});

async function loadFaculties() {
  const res = await fetch(FACULTY_API);
  const data = await res.json();
  facultyTable.innerHTML = "";

  data.forEach(f => {
    facultyTable.innerHTML += `
      <tr>
        <td>${f.id}</td><td>${f.name}</td><td>${f.subject}</td><td>${f.age}</td><td>${f.salary}</td>
        <td class="actions">
          <button class="edit" onclick='editFaculty(${JSON.stringify(f)})'>Edit</button>
          <button class="delete" onclick="deleteFaculty(${f.id})">Delete</button>
        </td>
      </tr>`;
  });
}

function editFaculty(f) {
  document.getElementById("faculty-id").value = f.id;
  document.getElementById("faculty-name").value = f.name;
  document.getElementById("faculty-subject").value = f.subject;
  document.getElementById("faculty-age").value = f.age;
  document.getElementById("faculty-salary").value = f.salary;
}

async function deleteFaculty(id) {
  if (confirm("Are you sure you want to delete this faculty?")) {
    await fetch(`${FACULTY_API}/${id}`, { method: "DELETE" });
    loadFaculties();
  }
}

// =======================
// STUDENT SECTION
// =======================
const studentForm = document.getElementById("student-form");
const studentTable = document.getElementById("student-table-body");

studentForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("student-id").value;
  const roll_no = parseInt(document.getElementById("student-roll").value);
  const name = document.getElementById("student-name").value;
  const age = parseInt(document.getElementById("student-age").value);
  const marks = parseInt(document.getElementById("student-marks").value);

  const data = { roll_no, name, age, marks };

  await fetch(`${STUDENT_API}${id ? '/' + id : ''}`, {
    method: id ? "PUT" : "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });

  studentForm.reset();
  document.getElementById("student-id").value = "";
  loadStudents();
});

async function loadStudents() {
  const res = await fetch(STUDENT_API);
  const data = await res.json();
  studentTable.innerHTML = "";

  data.forEach(s => {
    studentTable.innerHTML += `
      <tr>
        <td>${s.id}</td><td>${s.roll_no}</td><td>${s.name}</td><td>${s.age}</td><td>${s.marks}</td>
        <td class="actions">
          <button class="edit" onclick='editStudent(${JSON.stringify(s)})'>Edit</button>
          <button class="delete" onclick="deleteStudent(${s.id})">Delete</button>
        </td>
      </tr>`;
  });
}

function editStudent(s) {
  document.getElementById("student-id").value = s.id;
  document.getElementById("student-roll").value = s.roll_no;
  document.getElementById("student-name").value = s.name;
  document.getElementById("student-age").value = s.age;
  document.getElementById("student-marks").value = s.marks;
}

async function deleteStudent(id) {
  if (confirm("Are you sure you want to delete this student?")) {
    await fetch(`${STUDENT_API}/${id}`, { method: "DELETE" });
    loadStudents();
  }
}

// =======================
// INITIAL LOAD
// =======================
window.onload = () => {
  loadFaculties();
  loadStudents();
};
