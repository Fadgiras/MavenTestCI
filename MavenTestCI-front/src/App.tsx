import { useState } from 'react'
import './App.css'

interface SearchResult {
  rs: string
  finess: string
  ej_finess: string
}


function App() {
  const [searchQuery, setSearchQuery] = useState('')
  const [searchResults, setSearchResults] = useState<SearchResult[]>([])

  const handleSearch = (searchQuery: string) => {
    console.log('Search query:', searchQuery)

    // Fetching data from the API
    fetch(`http://localhost:8080/finess?query=${searchQuery}`)
      .then(response => response.json())
      .then(data => {
        setSearchQuery(searchQuery)
        console.log('Search results:', data)
        setSearchResults(data.results) // Assuming the API returns an object with a 'results' array
      })
      .catch(error => {
        console.error('Error fetching search results:', error)
      })
  }

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchQuery(event.target.value)
  }

  return (
    <div className="app">
      <div className="search-container">
        <form onSubmit={(e) => { e.preventDefault(); handleSearch(searchQuery); }} className="search-form">
          <input
            type="text"
            placeholder="Search..."
            value={searchQuery}
            onChange={handleSearchChange}
            className="search-bar"
          />
          <button type="submit">Search</button>
        </form>
      </div>
      <div className="search-results">
        {searchResults.map(result => (
          <div className="search-result-item" key={JSON.stringify(result)}>
            <h3>{result.rs}</h3>
            <p>Finess: {result.finess}</p>
            <p>Ej Finess: {result.ej_finess}</p>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App
