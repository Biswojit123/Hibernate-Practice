package com.biswo.test;

import java.util.Arrays;

import org.hibernate.Session;

import com.biswo.proxy.IMovie;
import com.biswo.utility.HibernateUtility;

public class LazyLoadingObjectThroughAnnotation {

	public static void main(String[] args) {
		// get the session object
		Session session = HibernateUtility.getSession();

		// Try and resource
		try (session) {
			// Get the Movie object
			// It is the by default load method perform the Lazy loading if we want to Eager
			// loading then we have to annotated a annotation that is @Proxy(lazy=false).If
			// we want the lazy loading then lazy=false add in entity level
			IMovie movie = session.load(IMovie.class, 12534);
			// In lazy loading that not hit the data base it only return the proxy object
			// i.e class com.biswo.entity.Movie$HibernateProxy$csift8jz
			// if we load eager loading then it hit the database and return the Movie object
			// i.e class com.biswo.entity.Movie
			System.out.println(movie.getClass()+"->super class ::"+movie.getClass().getSuperclass()+"Interface Imple::"+Arrays.toString(movie.getClass().getInterfaces()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
