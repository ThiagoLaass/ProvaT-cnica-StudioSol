document.getElementById('scoreForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const pontosTime1 = parseInt(document.getElementById('teamA').value);
    const pontosTime2 = parseInt(document.getElementById('teamB').value);

    const response = await fetch('http://127.0.0.1:8080/verify', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ pontosTime1, pontosTime2 })
    });

    if (!response.ok) {
        console.error('Network response was not ok', response);
        return;
    }
    const result = await response.json();
    console.log(result)
    displayResult(result);
});

function displayResult(result) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <p>Total de combinações possíveis: ${result.combinations}</p>
    `;
}
