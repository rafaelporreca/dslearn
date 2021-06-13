package br.com.rafaelporreca.dslearn.observers;

import br.com.rafaelporreca.dslearn.entities.Deliver;

public interface DeliverRevisionObserver {

    void onSaveRevision(Deliver deliver);
}
