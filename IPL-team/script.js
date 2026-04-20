document.addEventListener("DOMContentLoaded", () => {
  const menuToggle = document.querySelector(".menu-toggle");
  const navOverlay = document.querySelector(".nav-overlay");

  if (menuToggle && navOverlay) {
    menuToggle.addEventListener("click", () => {
      navOverlay.classList.toggle("active");
    });
  }

  const filterBtns = document.querySelectorAll(".filter-btn");
  const scheduleRows = document.querySelectorAll("#schedule-body tr");

  filterBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      filterBtns.forEach((b) => b.classList.remove("active"));
      btn.classList.add("active");
      const filterValue = btn.getAttribute("data-filter");

      scheduleRows.forEach((row) => {
        if (filterValue === "all") {
          row.style.display = "";
        } else if (row.classList.contains(filterValue)) {
          row.style.display = "";
        } else {
          row.style.display = "none";
        }
      });
    });
  });

  // Poll
  const pollForm = document.getElementById("pollForm");
  const pollResults = document.querySelector(".poll-results");

  if (pollForm) {
    pollForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const selected = document.querySelector('input[name="mvp"]:checked');
      if (selected) {
        pollForm.style.display = "none";
        pollResults.style.display = "block";
        pollResults.innerHTML = `
          <p>Thank you for voting! You chose <strong>${selected.value}</strong>.</p>
          <p>#OneFamily #DuniyaHilaDenge</p>
        `;
      } else {
        alert("Please select a player before voting!");
      }
    });
  }

  // Comment
  const commentForm = document.getElementById("commentForm");
  const commentsList = document.getElementById("commentsList");

  if (commentForm && commentsList) {
    commentForm.addEventListener("submit", (e) => {
      e.preventDefault();
      const nameInput = document.getElementById("commentName");
      const textInput = document.getElementById("commentText");

      if (nameInput.value.trim() !== "" && textInput.value.trim() !== "") {
        const newComment = document.createElement("div");
        newComment.classList.add("comment");

        const safeName = document.createTextNode(nameInput.value).textContent;
        const safeText = document.createTextNode(textInput.value).textContent;

        newComment.innerHTML = `<p><strong>${safeName}:</strong> ${safeText}</p>`;
        commentsList.insertBefore(newComment, commentsList.firstChild);

        nameInput.value = "";
        textInput.value = "";
      }
    });
  }
});
