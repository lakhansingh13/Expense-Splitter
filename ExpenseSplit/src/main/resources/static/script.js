const api = "http://localhost:8080/api";

async function addUser() {
  const id = document.getElementById("uid").value.trim();
  const name = document.getElementById("uname").value.trim();

  if (!id || !name) {
    alert("❗ Please enter both User ID and Name.");
    return;
  }

  await fetch(`${api}/user?id=${id}&name=${name}`, { method: "POST" });
  alert("✅ User Added!");
  document.getElementById("uid").value = "";
  document.getElementById("uname").value = "";
  loadUsers();
}

async function loadUsers() {
  const res = await fetch(`${api}/users`);
  const users = await res.json();
  const select = document.getElementById("paidBy");
  select.innerHTML = "";

  users.forEach(user => {
    const option = document.createElement("option");
    option.value = user.id;
    option.text = `${user.name} (${user.id})`;
    select.appendChild(option);
  });
}

async function addExpense() {
  const paidBy = document.getElementById("paidBy").value;
  const amount = parseFloat(document.getElementById("amount").value);
  const splitWith = document.getElementById("splitWith").value
    .split(",")
    .map(id => id.trim())
    .filter(id => id);

  if (!paidBy || isNaN(amount) || amount <= 0 || splitWith.length === 0) {
    alert("❗ Please fill all expense fields correctly.");
    return;
  }

  const perPerson = +(amount / splitWith.length).toFixed(2);
  const splits = {};
  splitWith.forEach(id => splits[id] = perPerson);

  await fetch(`${api}/expense?paidBy=${paidBy}&amount=${amount}&type=EXACT`, {
    method: "POST",
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(splits)
  });

  alert("✅ Expense Added!");
  document.getElementById("amount").value = "";
  document.getElementById("splitWith").value = "";
}

async function settle() {
  const from = document.getElementById("from").value.trim();
  const to = document.getElementById("to").value.trim();

  if (!from || !to) {
    alert("❗ Please enter both From and To user IDs.");
    return;
  }

  await fetch(`${api}/settle?from=${from}&to=${to}`, { method: "POST" });
  alert("✅ Debt Settled!");
  document.getElementById("from").value = "";
  document.getElementById("to").value = "";
  loadBalances();
}

async function loadBalances() {
  const res = await fetch(`${api}/balances`);
  const balances = await res.json();

  let html = "";
  for (const from in balances) {
    for (const to in balances[from]) {
      html += `<p>💳 <strong>${from}</strong> owes <strong>${to}</strong>: ₹${balances[from][to].toFixed(2)}</p>`;
    }
  }

  const box = document.getElementById("balanceBox");
  box.innerHTML = html || "<p>No balances yet! 🧾</p>";
  box.style.animation = "fadeIn 0.5s";
}

window.onload = loadUsers;
