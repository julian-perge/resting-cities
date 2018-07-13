// Create a function to remove a city
const cityList = document.querySelector('.cityList')
	// Create event listener
cityList.addEventListener('click', removeCity)

function removeCity(event) {
	if (event.target.classList.contains('delete')) {
		// select delete button
		const deleteButton = event.target
		
		// traverse to city container
		const cityContainer = deleteButton.parentElement
		
		// get 'href' attribute from link
		const hrefArray = cityContainer.querySelector('a').getAttribute('href').split("/")
		const abbreviation = hrefArray[2]
		const cityId = hrefArray[4]
		
		// set up action for response
		const xhr = new XMLHttpRequest()
		// repopulate list with existing cities (pass response as a parameter)
		xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingCities = JSON.parse(response.currentTarget.response);
				let list = ''
				remainingCities.forEach(function(city) {
					// `abbreviation` and `cityId` reference lines 16 & 17
					list += `
						<li>
							<a href="/states/${abbreviation}/cities/${cityId}">
								${city.name}
							</a>
							<!-- Create a .delete button -->
							<button class="delete">Remove</button>
						</li>
					`
				})
				cityList.innerHTML = list
			}
		}
		
		// send request to server
		xhr.open("DELETE", `/api/states/${abbreviation}/cities?id=${cityId}`, true)
		xhr.send()
		
	}
}