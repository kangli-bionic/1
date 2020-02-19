context('Enter invalid data', () => {
    beforeEach(() => {
        cy.visit()
    })

    it('Should throw error message when enter negative number ', () => {
        // arrange
        cy.reload();
        // act
        cy.get('[data-testid=fizzbuzz-input]').type(-12);
        // assert
        cy.get('[data-testid=fizzbuzz-error]');
    });

    it('Should throw error message when enter 0 ', () => {
        // arrange
        cy.reload();
        // act
        cy.get('[data-testid=fizzbuzz-input]').type(0);
        // assert
        cy.get('[data-testid=fizzbuzz-error]');
    });

    it('Should remove error message when enter natural number ', () => {
        // arrange
        cy.reload();

        // act
        cy.get('[data-testid=fizzbuzz-input]').type(-99);

        // assert
        cy.get('[data-testid=fizzbuzz-error]');
        cy.get('[data-testid=fizzbuzz-input]').clear();
        cy.get('[data-testid=fizzbuzz-input]').type(10);
        cy.get('[data-testid=fizzbuzz-error]').should('not.be.visible') ;
        cy.get('[data-testid=fizzbuzz-input]').clear();
    });

    it('Should clear the input field after clicking on cancel ', () => {
        // arrange
        // act
        cy.get('[data-testid=fizzbuzz-input]').type(111);
        cy.get('[data-testid=fizzbuzz-button-cancel]').click();
        // assert
        cy.get('[data-testid=fizzbuzz-input]').should('be.empty');
    });
})
