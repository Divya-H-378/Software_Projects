// durationMinutes comes from test.html (set via Thymeleaf inline script)
let totalSeconds = durationMinutes * 60;

const timerDisplay = document.getElementById("timer");
const examForm = document.getElementById("examForm");

function updateTimerDisplay() {
    const minutes = Math.floor(totalSeconds / 60);
    const seconds = totalSeconds % 60;
    timerDisplay.textContent =
        String(minutes).padStart(2, '0') + ":" + String(seconds).padStart(2, '0');
}

function startTimer() {
    updateTimerDisplay();

    const interval = setInterval(() => {
        totalSeconds--;

        if (totalSeconds <= 0) {
            clearInterval(interval);
            timerDisplay.textContent = "00:00";
            alert("Time is up! Submitting your test automatically.");
            examForm.submit();
            return;
        }

        updateTimerDisplay();
    }, 1000);
}

// Only run timer logic if we're on the exam page (i.e., timer element exists)
if (timerDisplay && examForm) {
    startTimer();
}