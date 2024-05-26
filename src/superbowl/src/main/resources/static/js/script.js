document.getElementById('scoreForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const teamA = parseInt(document.getElementById('teamA').value);
    const teamB = parseInt(document.getElementById('teamB').value);

    const response = await fetch('/api/combinations', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ teamA, teamB })
    });

    const result = await response.json();
    displayResult(result);
});

function displayResult(result) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <p>Combinações possíveis para Time A: ${result.combinationsA}</p>
        <p>Combinações possíveis para Time B: ${result.combinationsB}</p>
        <p>Total de combinações possíveis: ${result.totalCombinations}</p>
    `;
}
