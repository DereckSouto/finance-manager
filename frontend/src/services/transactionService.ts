import type { TransactionResponse } from "../types/TransactionResponse";
import type { TransactionSummaryResponse } from "../types/TransactionSummaryResponse";

const API_URL = import.meta.env.VITE_API_URL;

export async function getAll() {

    console.log("API URL: ", API_URL);
    // connect to API using fetch
    const response = await fetch(`${API_URL}/transactions`);

    if (!response.ok) {
        console.log(`Failed to fetch transactions: ${response.status}`);
    }

    // asign json response to variable 
    const data = (await response.json()) as TransactionResponse[];

    // method returns a list of TransactioResponse
    return data;

}

export async function getSummary() {
    const response = await fetch(`${API_URL}/transactions/summary`);
    
    if (!response.ok) {
        console.log("Failed to fetch summary!")
    }

    return (await response.json()) as TransactionSummaryResponse;
}