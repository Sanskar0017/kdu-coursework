export const fetchRandomQuotes = async (limit = 3) => {
  try {
    const response = await fetch(
      `https://api.quotable.io/quotes/random?limit=${limit}`
    );
    const data = await response.json();
    return data;
  } catch (error) {
    throw new Error("Error fetching quotes");
  }
};
