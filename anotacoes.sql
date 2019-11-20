SELECT S FROM Sessao S 
    JOIN Filme F ON (F.codigo = S.filme.codigo) 
    WHERE (S.arquivada = 0) AND (S.sala.codigo = :sala) AND 
    (
        (S.dataInicio BETWEEN :inicio AND :fim) OR 
        ((S.dataInicio + S.filme.duracao) BETWEEN :inicio AND :fim)
    )

SELECT * FROM sessao S 
    JOIN filme F ON (F.codigo = S.filme_codigo) 
    WHERE (S.arquivada = 0) AND (S.sala_codigo = 1) AND 
    (
        ( S.data_inicio BETWEEN '2019-11-16 23:10:52' AND '2019-11-16 23:50:52') OR 
        (( S.data_inicio + F.duracao) BETWEEN '2019-11-16 23:10:52' AND '2019-11-16 23:50:52')
    )