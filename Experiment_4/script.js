const apiKey = "f06d5dc44c45685dbfc0a330ef4207f8"; 

let chart;

// Arrow Function + Async/Await
const getWeather = async () => {
  const city = document.getElementById("city").value;

  if (!city) {
    alert("Please enter a city name");
    return;
  }

  try {
    const response = await fetch(
      `https://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${apiKey}&units=metric`
    );

    const data = await response.json();

    console.log(data);

    if (data.cod !== "200") {
      alert("Error: " + data.message);
      return;
    }

    processWeather(data, displayGraph);

  } catch (error) {
    console.error("Error:", error);
    alert("Something went wrong!");
  }
};

// Callback Function
const processWeather = (data, callback) => {
  const temps = data.list.slice(0, 8).map(item => item.main.temp);
  const labels = data.list.slice(0, 8).map(item => item.dt_txt);

  callback(labels, temps);
};

// Promise example
const fakePromise = () => {
  return new Promise(resolve => {
    resolve("Promise executed");
  });
};

fakePromise().then(console.log);

// Graph display
const displayGraph = (labels, temps) => {
  const ctx = document.getElementById("weatherChart").getContext("2d");

  if (chart) chart.destroy();

  chart = new Chart(ctx, {
    type: "line",
    data: {
      labels: labels,
      datasets: [{
        label: "Temperature (°C)",
        data: temps,
        borderWidth: 2,
        backgroundColor: "rgba(75,192,192,0.2)", 
        borderColor: "blue",
        fill: true,
        tension: 0.3
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false
    }
  });
};