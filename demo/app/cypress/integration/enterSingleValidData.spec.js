import {
    deleteAllFizzBuzzItems,
} from '../support/utils';

context('Enter valid data', () => {
    beforeEach(() => {
        cy.visit()
        deleteAllFizzBuzzItems();
    })

    const FIZZ = "Fizz";
    const BUZZ = "Buzz";

    function insertNewFizzBuzzItem({input, fbAssertion}) {
        cy.get('[data-testid=fizzbuzz-input]').type(input);
        cy.get('[data-testid=fizzbuzz-button-submit]').click();
        cy.get('[data-testid=fizzbuzz-row]').contains(input);
        cy.get('[data-testid=fizzbuzz-row]').contains(new RegExp(`^${fbAssertion}$`, "g"));
    }

    it('Should type in number divisible by 3 ', () => {
        insertNewFizzBuzzItem({input: 333, fbAssertion: FIZZ});
    });

    it('Should type in another number divisible by 3 ', () => {
        insertNewFizzBuzzItem({input: 12, fbAssertion: FIZZ});
    });

    it('Should type in number divisible by 5 ', () => {
        insertNewFizzBuzzItem({input: 5, fbAssertion: BUZZ});
    });

    it('Should type in another number divisible by 5 ', () => {
        insertNewFizzBuzzItem({input: 25, fbAssertion: BUZZ});
    });

    it('Should type in number divisible by 15 ', () => {
        insertNewFizzBuzzItem({input: 15, fbAssertion: `${FIZZ} ${BUZZ}`});
    });

    it('Should type in another number divisible by 15 ', () => {
        insertNewFizzBuzzItem({input: 30, fbAssertion: `${FIZZ} ${BUZZ}`});
    });

    it('Should type in another number divisible by 15 ', () => {
        insertNewFizzBuzzItem({input: 30, fbAssertion: `${FIZZ} ${BUZZ}`});
    });

    it('Should type in non fizzBuzzy number', () => {
        insertNewFizzBuzzItem({input: 7, fbAssertion: 7});
    });

    it('Should type in another non fizzBuzzy number', () => {
        insertNewFizzBuzzItem({input: 11, fbAssertion: 11});
    });

})
