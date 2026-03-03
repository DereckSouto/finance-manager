import Table from "../components/Table";
import { useTransactions } from "../hooks/useTransactions";

export default function TransactionsPage() {

    const { transactions, loading, error } = useTransactions();

    if (loading) {
        return <p>Loading...</p>
    }
    if (error) {
        return <p>{error}</p>
    }

    return (
        <div className="min-h-screen bg-gray-800 p-8">
            <div className="max-w-5xl mx-auto bg-white rounded-xl shadow-md p-6">
                <h1 className="text-2xl font-semibold mb-6">Transactions</h1>
                <Table transactions={transactions} />
            </div>
        </div>
    );

}