type FilterButtonProps = {
    filter: string;
    setFilter: React.Dispatch<React.SetStateAction<string>>;
}

const buttons: string[] = ["ALL", "INCOME", "EXPENSE"];

export default function FilterButtons({ filter, setFilter }: FilterButtonProps) {
    return (
        <>
            {buttons.map((b) => {
                return (
                    <button key={b} onClick={() => setFilter(b)}
                        className={`cursor-pointer ${filter === b ? "bg-gray-800 shadow-md" : "bg-gray-600"} hover:bg-gray-800 rounded-2xl p-2 w-20 text-gray-50`}>{b.charAt(0) + b.slice(1).toLowerCase()}</button>
                )
            })}
        </>
    );
}