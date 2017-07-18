# -*- coding: utf-8 -*-
"""
Created on Wed Jun 28 12:47:36 2017

@author: yang
"""

from decimal import Decimal, getcontext

from Vector import Vector

getcontext().prec = 30


class Line(object):

    NO_NONZERO_ELTS_FOUND_MSG = 'No nonzero elements found'
    NO_INTERCEPTION_POINT_MSG = "There is not interception point for parallel lines"
    SAME_LINE_MSG = "The lines are the same line"

    def __init__(self, normal_vector=None, constant_term=None):
        self.dimension = 2

        if not normal_vector:
            all_zeros = ['0']*self.dimension
            normal_vector = Vector(all_zeros)
        self.normal_vector = normal_vector

        if not constant_term:
            constant_term = float('0')
        self.constant_term = float(constant_term)

        self.set_basepoint()


    def set_basepoint(self):
        try:
            n = self.normal_vector.coordinates
            c = self.constant_term
            
            basepoint_coords = [0]*self.dimension

            initial_index = Line.first_nonzero_index(n)
            initial_coefficient = n[initial_index]
            
            basepoint_coords[initial_index] = c/initial_coefficient
            self.basepoint = Vector(basepoint_coords)

        except Exception as e:
            if str(e) == Line.NO_NONZERO_ELTS_FOUND_MSG:
                self.basepoint = None
            else:
                raise e


    def __str__(self):

        num_decimal_places = 3

        def write_coefficient(coefficient, is_initial_term=False):
            coefficient = round(coefficient, num_decimal_places)
            if coefficient % 1 == 0:
                coefficient = int(coefficient)

            output = ''

            if coefficient < 0:
                output += '-'
            if coefficient > 0 and not is_initial_term:
                output += '+'

            if not is_initial_term:
                output += ' '

            if abs(coefficient) != 1:
                output += '{}'.format(abs(coefficient))

            return output

        n = self.normal_vector.coordinates

        try:
            initial_index = Line.first_nonzero_index(n)
            terms = [write_coefficient(n[i], is_initial_term=(i==initial_index)) + 'x_{}'.format(i+1)
                     for i in range(self.dimension) if round(n[i], num_decimal_places) != 0]
            output = ' '.join(terms)

        except Exception as e:
            if str(e) == self.NO_NONZERO_ELTS_FOUND_MSG:
                output = '0'
            else:
                raise e

        constant = round(self.constant_term, num_decimal_places)
        if constant % 1 == 0:
            constant = int(constant)
        output += ' = {}'.format(constant)

        return output


    def is_parallel(self,other):
        n1 = self.normal_vector
        n2 = other.normal_vector
        return n1.is_parallel(n2)
    
    def __eq__(self,other):
        if self.normal_vector.is_zero():
            if other.normal_vector.is_zero():
                return Line.is_near_zero(self.constant_term-other.constant_termr)
            else:
                return False
            
        n1 = self.normal_vector
        n2 = other.normal_vector
        
        v = self.basepoint - other.basepoint
        
        
        return (v.dot_product(n1)==0 and v.dot_product(n2)==0 and self.is_parallel(other))
        
    def intercetion(self,other):
        if self == other:
            return self
        elif self.is_parallel(other):
            return None
        else:
            a,b = self.normal_vector.coordinates
            c,d = other.normal_vector.coordinates
            k1 = self.constant_term
            k2 = other.constant_term
            x = (d*k1-b*k2)/(a*d - b*c)
            y = (-c*k1+a*k2)/(a*d - b*c)
            return (x,y)

    @staticmethod
    def first_nonzero_index(iterable):
        for k, item in enumerate(iterable):
            if not MyDecimal(item).is_near_zero():
                return k
        raise Exception(Line.NO_NONZERO_ELTS_FOUND_MSG)
        
    @staticmethod
    def is_near_zero(value, eps=1e-10):
        return abs(value) < eps 


class MyDecimal(Decimal):
    def is_near_zero(self, eps=1e-10):
        return abs(self) < eps
    
if __name__ == '__main__':
#    l1 = Line(normal_vector=Vector((4.046,2.836)),constant_term=1.21)
#    l2 = Line(normal_vector=Vector((10.115,7.09)),constant_term=3.025)
#    print(l1.is_parallel(l2))
#    print(l1==l2)
#    print(l1.intercetion(l2))
    
    l1 = Line(normal_vector=Vector((1,1)),constant_term=4)
    l2 = Line(normal_vector=Vector((3,4)),constant_term=8)
    print(l1.is_parallel(l2))
    print(l1==l2)
    print(l1.intercetion(l2))
    
    l1 = Line(normal_vector=Vector((7.204,3.182)),constant_term=8.68)
    l2 = Line(normal_vector=Vector((8.172,4.114)),constant_term=9.883)
    print(l1.is_parallel(l2))
    print(l1==l2)
    print(l1.intercetion(l2))
    
    l1 = Line(normal_vector=Vector((1.182,5.562)),constant_term=6.744)
    l2 = Line(normal_vector=Vector((1.773,8.343)),constant_term=9.525)
    print(l1.is_parallel(l2))
    print(l1==l2)
    print(l1.intercetion(l2))