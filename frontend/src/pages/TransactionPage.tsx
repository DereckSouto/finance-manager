import { useState } from "react";
import Table from "../components/Table";
import { useTransactions } from "../hooks/useTransactions";
import FilterButtons from "../components/FIlterButtons";
import { Plus } from "lucide-react";
import { TransactionDialog } from "../components/TransactionDialog";

export default function TransactionsPage() {

    const { transactions, loading, error, balance } = useTransactions();
    const [filter, setFilter] = useState("ALL");
    const [open, setOpen] = useState(false);

    if (loading) {
        return <p>Loading...</p>
    }
    if (error) {
        return <p>{error}</p>
    }

    return (
        <div className="min-h-screen bg-gray-800 p-8">

            <div className="max-w-5xl mx-auto rounded-xl bg-white mb-2 flex gap-2 p-3">
                <FilterButtons filter={filter} setFilter={setFilter} />
            </div>

            <div className="max-w-5xl mx-auto bg-white rounded-xl shadow-md p-6 content-be">
                <div className="flex flex-row justify-between w-full">
                    <h1 className="text-2xl font-semibold mb-6">Transactions</h1>
                    <h1 className="text-2xl font-semibold mb-6">Total Balance: {new Intl.NumberFormat("pt-BR", {
                        style: "currency",
                        currency: "BRL",
                    }).format(balance)}</h1>
                </div>
                <Table transactions={transactions} filter={filter} />
            </div>

            <button className="cursor-pointer bg-gray-700 rounded-full w-16 h-16 flex items-center justify-center ml-auto text-gray-50 right-10 bottom-10 fixed"
            onClick={() => setOpen(true)}>
                <Plus size={20} />
            </button>
            <TransactionDialog open={open} onClose={setOpen} />
        </div>
    );

}