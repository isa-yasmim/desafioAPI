import { useState } from "react";

export default function Conta() {
    const [id, setId] = useState("");
    const [conta, setConta] = useState(null);
    const [error, setError] = useState(null);

    const handleGetConta = async (e) => {
        e.preventDefault();
        if (!id.trim()) return;

        try {
            const res = await fetch(`http://localhost:8080/api/conta/${id}`);
            if (!res.ok) {
                throw new Error("Conta não encontrada");
            }

            const data = await res.json();
            setConta(data);
            setError(null);
        }
        catch (err) {
            setError(err.message);
        }
    };

    return (
        <div>
            <h1>Buscar dados da conta</h1>
            <form onSubmit={handleGetConta}>
                <input
                    type="number"
                    placeholder="ID"
                    value={id}
                    onChange={(e) => setId(e.target.value)}
                />
                <button type="submit"> Busca </button>
            </form>

            {error && <p> {error} </p>}

            {conta && (
                <div>
                    <h1> Conta {conta.idConta} </h1>
                    <p>Nome: {conta.pessoa?.nome} </p>
                    <p>Conta {getTipoContaTexto(conta.tipoConta)} </p>
                    <p>Saldo: {conta.saldo} </p>
                    <p>Limite de saque: {conta.limiteSaqueDiario} </p>
                    <p>Status: {getFlagAtivoTexto(conta.flagAtivo)}</p>
                </div>
            )}
        </div>
    )
}

function getTipoContaTexto(tipo) {
    switch (tipo) {
        case 1: return "corrente";
        case 2: return "salário";
        case 3: return "poupança";
        default: return "Erro";
    }
}

function getFlagAtivoTexto(flagAtivo) {
    if (flagAtivo == 1) {
        return "Ativa"
    }
    else {
        return "Bloqueada"
    }
}
