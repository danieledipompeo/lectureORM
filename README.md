# lectureORM

## Introduzione
Materiale utile per il seminario su Hibernate per il corso di Ingegneria del Software di Ingegneria Informatica ed Automatica A.A 2015/2016.

Il seminario prevede come pre-requisiti la conoscenza di:

1. Ambiente di sviluppo Eclipse (utilizzata la versione Mars)
2. MySQL come R-DBMS.

## Dominio
Per questo seminario e' stato utilizzato il dominio applicativo universitario, mappando le classi:

1. Person
2. Student
3. Phone
4. Address
5. Transcript
6. Course

### Relazioni tra classi
Nel dominio e' stata considerata l'ereditarieta' tra Person e Student. La classe Person ha una relazione di 1 a M con la classe Address, la classe Student e'in relazione 1 a 1 con la classe Transcript. Student ha inoltre una relazione 1 a M con la classe Phone. Course e' in relazione N a M con la classe Student.

## Organizzazione del repository
Sono presenti 7 progetti eclipse con difficolta' incrementale:

1. University_OtO
2. University_OtM
3. University_MtO
4. University_MtM

I progetti 

1. University_SingleTable
2. University_Joined
3. Univesrity_TablePerClass

sono utilizzati per riportare esempi sulla gestione della ereditarieta' tra oggetti, ovvero rispettano le tre modalita' di gestione offerte da Hibernate.

## Database settings
Per i prinmi 4 progetti e' stato utilizzato un solo database "university_basic". Per accedere al db sono state utilizzati:

- user : root
- password : toor

Per i restati progetti e' stato creato un database per ogni progetto con il seguente pattern

- university_\<nome_pregetto\>

utilizzando le stesse credenziali dei precedenti progetti.
